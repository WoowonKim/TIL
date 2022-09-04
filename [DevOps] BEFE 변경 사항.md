# [DevOps] BE/FE 변경 사항 

## BackEnd 

### fb_key.json 경로 변경

1. 기존 (경로 : /fb_key.json)

   ```java
   FileInputStream serviceAccount = new FileInputStream("fb_key.json");
               FirebaseOptions options = FirebaseOptions.builder()
                       .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                       .build();
   ```

2. 변경 (경로 : /path/to/serviceAccountKey.json)

   ```java
   FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");
               FirebaseOptions options = FirebaseOptions.builder()
                       .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                       .build();
   ```

이유 : firebase 공홈에서 이렇게 쓰라한다.

![image-20220804144046264](C:\Users\skycoms\AppData\Roaming\Typora\typora-user-images\image-20220804144046264.png)

### WebConfiguration CORS 처리

```java
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://i7b103.p.ssafy.io","http://i7b103.p.ssafy.io:80", "http://localhost:3000");
    }
}
```

이유 : 컨트롤러 만들때마다 설정하기 귀찮으니까

- localhost:3000 : 개발할때 리액트에서 요청
- http://i7b103.p.ssafy.io : 도메인에서 요청

> 뭔가 http://localhost만 설정해놔도 될거 같기도 한데 아직 안해봄

## FrontEnd

### 문제 

백엔드 jar파일을 배포하고 실행을 했는데... talend, local에서 다 요청이 가는데 배포된 도메인에서의 요청만 안감...

### 이유

**이유** : Spring Boot의 톰캣 포트가 8002여서 package.json에 "proxy": "http://localhost:8002"를 추가하여 개발 하였는데... 이 설정은 npm start에서만 설정되고 배포를 위해 npm build를 할땐 적용이 안된다고 한다...
참고자료 : https://create-react-app.dev/docs/proxying-api-requests-in-development/

### 해결

처음엔 nginx에서 프록시 설정을 할까 했는데 일단은 axios 요청 방식을 바꾸는 쪽으로 생각 중...

1. 루트 폴더에 .env.development 와 .env.production 파일 추가

​	.env.development

```
REACT_APP_BE_HOST='http://localhost:8002/'
```

​	.env.production

```
REACT_APP_BE_HOST='http://i7b103.p.ssafy.io:8002/'
```

- **참고** (사용되는 .env file, 우선순위 순)

  - npm start : .env.development.local > .env.local > .env.development > .env

  - npm run build : .env.production.local > .env.local > .env.production > .env

  - npm test : .env.test.local > .env.test > .env

  

2. axios 요청 방식 변경

   - /store에 axiosService.js 추가

   ```javascript
   import axios from "axios";
   
   export const axiosService = axios.create({
     baseURL: process.env.REACT_APP_BE_HOST,
     headers: {
       "Content-Type": "application/json",
       "auth-token": "",
     },
   });
   ```

   기존 요청 방식

   ```jsx
   // 이메일 중복 확인
   export const emailCheck = createAsyncThunk(
     "user/email/check/",
     async (args, { rejectWithValue }) => {
       try {
         const response = await axios({
           baseURL: process.env.REACT_APP_BE_HOST,
           url: `/user/email`,
           method: "get",
           params: {
             email: args.email,
           },
         });
         return response.data;
       } catch (err) {
         return rejectWithValue(err.response);
       }
     }
   );
   ```

   변경 후 요청 방식

   ```jsx
   import { axiosService } from "../axiosService";
   
   // 이메일 중복 확인
   export const emailCheck = createAsyncThunk(
     "user/email/check/",
     async (args, { rejectWithValue }) => {
       try {
         const response = await axiosService.get(`/user/email`, args.email);
         return response.data;
       } catch (err) {
         return rejectWithValue(err.response);
       }
     }
   );
   ```

   axios 참고 : https://inpa.tistory.com/entry/AXIOS-%F0%9F%93%9A-%EC%84%A4%EC%B9%98-%EC%82%AC%EC%9A%A9

   ps. 지금 userSlice의 emailCheck의 이름이 "user/email/check"로 되어 있는데 리팩토링 하면서 

   "{slice이름}/{함수이름}"으로 하는거 어떨까요 (예 : "userSlice/emailCheck") 