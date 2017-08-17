import json
import cProfile

def main():
    #loading json with users data
    with open('users.json') as json_data:
        usersJSON = json.load(json_data)
        print(usersJSON)

    #Iterating over json for each line retun the "user" and "password" values,saving them in json 
    #for writing in another file usage
        toData = {
            'users': list(map(lambda user: user['username'] + ':' + user['password'], usersJSON))
        }

    #using json toData to write the the new txt "user" data    
        with open('users.txt', 'w') as outfile:    
            json.dump(toData, outfile)       

main()

cProfile.run('main()')