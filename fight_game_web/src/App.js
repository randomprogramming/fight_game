import React from "react";
import { Switch, Route } from "react-router-dom";
import { Homepage } from "./views/Homepage";

function App() {
	return (
		<Switch>
			<Route exact path="/">
				<Homepage />
			</Route>
		</Switch>
	);
}

export default App;
