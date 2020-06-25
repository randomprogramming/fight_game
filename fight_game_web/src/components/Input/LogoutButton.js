import React from "react";
import { useDispatch } from "react-redux";
import axios from "axios";

import { logoutPlayer } from "../../redux/actions/PlayerActions";
import { LOGOUT } from "../../constants";

export const LogoutButton = () => {
	const dispatch = useDispatch();

	const handleLogout = () => {
		// Request the server to log us out, if we were logged out successfully, we also delete the stored player from the redux store
		axios.get(LOGOUT).then((res) => {
			if (res.status === 200) {
				console.log("should be dispatching");
				dispatch(logoutPlayer());
			}
		});
	};
	return (
		<img
			src="https://i.imgur.com/HJID5ZY.png"
			alt="logout button"
			style={{ height: "50%", width: "auto", cursor: "pointer", padding: "3px", margin: "0 1.5em" }}
			onClick={handleLogout}
		></img>
	);
};
