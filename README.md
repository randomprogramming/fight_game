# Fight Game

Server side for my Fight Game.

PostgreSQL is necessary to run.

# Endpoints

| Endpoint | Method |Requests | Returns |
| :---: | :---: | --- | --- |
| `/api/me` | GET | Nothing | `Player` object or error if player isn't logged in. |
| `/api/login` | POST | `String` username<br />`String` password | `String` saying if the login succeeded or failed. |
| `/api/register` | POST | `PlayerModel` object | `String` saying if the registration succeeded or failed. |
| `/api/findplayerbyusername/{username}` | GET | `String {username}` | `Player` object or error if user wasn't found. |