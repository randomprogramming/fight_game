import React, { useEffect } from "react";
import { Switch, Route } from "react-router-dom";

import { Homepage } from "./views/Homepage";
import { fetchAndDispatchPlayer } from "./redux/actions/PlayerActions";

function App() {
	useEffect(() => {
		fetchAndDispatchPlayer();
	}, []);
	return (
		<Switch>
			<Route exact path="/">
				<Homepage />
			</Route>
		</Switch>
	);
}

export default App;
