# Fight Game

Server side for my Fight Game.

# Endpoints

- `/api/me` - Requests nothing. Returns information about the currently logged in Player.
- `/api/register` - Requests a `PlayerModel` object, which gets converted into a `Player` object.
Returns a message if the registration succeeded or failed, and if failed, a message why it failed.