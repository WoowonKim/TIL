import json


def max_revenue(movies):
    max_revenue_budget = 0
    for movie in movies:
        id = movie.get('id')
        dir = 'data/movies/' + str(id) + '.json'
        movies_spe_json = open(dir, encoding='UTF8')
        movies_moreinfo = json.load(movies_spe_json)
        revenue = movies_moreinfo['revenue']
        if revenue > max_revenue_budget:
            max_revenue_budget = revenue
            max_revenue_name = movies_moreinfo['title']
    return max_revenue_name

 
if __name__ == '__main__':
    movies_json = open('data/movies.json', encoding='UTF8')
    movies_list = json.load(movies_json)
    
    print(max_revenue(movies_list))