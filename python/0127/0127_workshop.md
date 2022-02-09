# 0127 WORKSHOP



## 1.  도형 만들기

> 아래의 명세를 읽고 Python 클래스를 활용하여 점(Point)과 사각형(Rectangle)을 표현하시오.

``` python
class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y


class Rectangle:
    def __init__(self, p1, p2):
        self.p1 = p1
        self.p2 = p2

    def get_area(self):
        width = self.p2.x - self.p1.x
        height = self.p1.y - self.p2.y
        return width * height

    def get_perimeter(self):
        width = self.p2.x - self.p1.x
        height = self.p1.y - self.p2.y
        return (width + height) * 2

    def is_square(self):
        width = self.p2.x - self.p1.x
        height = self.p1.y - self.p2.y
        return width == height
   
p1 = Point(1, 3)
p2 = Point(3, 1)
r1 = Rectangle(p1, p2)
print(r1.get_area())
print(r1.get_perimeter())
print(r1.is_square())
p3 = Point(3, 7)
p4 = Point(6, 4)
r2 = Rectangle(p3, p4)
print(r2.get_area())
print(r2.get_perimeter())
print(r2.is_square())
```



