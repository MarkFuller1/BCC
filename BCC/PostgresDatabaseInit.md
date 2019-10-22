

# How to Postgres

This was easily the hardest time i've ever had trying to get a db to work so i'm making this and I apologize in advance.

## Install Postgres

[download](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) and run through the installer. Remember all the paths and stuff you agree to.

## Creating Postgres Environment

So youre going to need a few `ENVIRONMENT VARIABLES`

| variable name | my path, don't use mine but you get the idea         |                                                                                                            |   |   |
|---------------|------------------------------------------------------|------------------------------------------------------------------------------------------------------------|---|---|
| CLASSPATH     | C:\some\path\postgresql-42.2.8.jar | The path to the postgres jar, idk if you need it so try it without first and if eclipse errors then add it |   |   |
| PGDATA        | C:\some\path\to\BNU\database     | This is the path to the database you chose in the installer                                                
| PATH          | C:\Program Files\PostgreSQL\9.4\bin                  | add the bin to your path
|DBNAME         |"Mark Fuller   |  again this is mine don't use mine |
|DBPASS | 0000 | dont use mine, just an example

## Starting Postgres

### Summary on databases
So postgres runs on a port on your computer and Java connects to it through a fun API (which im working on writing something for). The port will be `localhost:5432` as per your install specification. The server postgres runs on essentially just accepts http requests and guides them to an endpoint. i.e. you can make a `GET` request to `localhost:5432\database\users\<userid>` and it will go to that endpoint in our controller, also called an API and will `GET` the user with that id. 

**tl,dr**. we need to start postgres,  then run the application



Make sure you remember your username and password && the paths for where things are located. If you don't know what your username is do...

`spql --help` on windows (sorry mac idk what yours is) and look down at the line that has

`-U username=USERNAME` your username will be the default value to the right
 
 ## start postgres
 to start the database we first need a database to connect to. When I say database here I mean the structure that the data will be held not the service that hosts that database. To create a database go to the place you want the database.

*I put mine in the BNU repo and I just won't commit it*

Or if you did the installer I did, you should have already picked a location for it. 
Go there and run 
`pg_ctl -D <path to db dir> -l logfile start`

it should say
`server starting`

then to get to the postgres terminal which is the command center for the service, do
`psql -h localhost`

I think thats it

## The java bit
you need to add this to your pom but I already did but in case we need it again 
```xml
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<version>9.4.1212</version>
</dependency>
```

and then refresh your project by doing `<right-click>` on project -> Maven -> Update Project
And I hope the rest will be ok
