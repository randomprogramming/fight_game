# Fight Game

Server side for my Fight Game.

# Endpoints

- `/api/me` - GET - Requests nothing. Returns information about the currently logged in Player.
- `/api/register` - POST - Requests a `PlayerModel` object, which gets converted into a `Player` object.
Returns a message if the registration succeeded or failed, and if failed, a message why it failed.
- `/api/findplayerbyusername/{username}` - GET - Searches the database for the Player that matches the
`{username}`. Returns a `Player` object, or an error message if the user with the `{username}` wasn't found.