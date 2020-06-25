import axios from "axios";

import { SET_PLAYER, LOGOUT_PLAYER } from "./ActionTypes";
import { GET_ME } from "../../constants";
import store from "../store";

export const fetchAndDispatchPlayer = () => {
	// Fetches the current logged in player from the server, if player is not logged in, we return null
	axios
		.get(GET_ME)
		.then((res) => {
			if (res.status === 200) store.dispatch({ type: SET_PLAYER, payload: res.data });
		})
		.catch((e) => store.dispatch({ type: SET_PLAYER, payload: null }));
};

export const logoutPlayer = () => {
	return { type: LOGOUT_PLAYER };
};
