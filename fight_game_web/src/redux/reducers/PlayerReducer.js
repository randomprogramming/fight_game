import { SET_PLAYER } from "../actions/ActionTypes";

const initialState = {
	username: null,
	isLoggedIn: false,
};

export default function (state = initialState, action) {
	switch (action.type) {
		case SET_PLAYER: {
			// If the payload is defined, it means that the player is logged in
			// If the payload is not defined, player is not logged in and therefore we set the state to initialState
			if (action.payload) {
				return action.payload;
			} else {
				return initialState;
			}
		}
		default: {
			return state;
		}
	}
}
