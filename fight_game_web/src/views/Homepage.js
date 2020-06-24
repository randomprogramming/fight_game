import React from "react";
import styled from "styled-components";

import { NavigationMenu } from "../components/NavigationMenu/NavigationMenu";
import { TopBarContainer } from "../components/TopBarContainer";
import { PRIMARY_BACKGROUND_COLOR } from "../constants";

const Container = styled.div`
	display: flex;
	flex-direction: row;
	height: 100%;
`;

const Content = styled.div`
	flex: 1;
	padding-left: 15px;
	background-color: ${PRIMARY_BACKGROUND_COLOR};
`;

export const Homepage = () => {
	return (
		<Container>
			<NavigationMenu />
			<Content>
				<TopBarContainer>Give left margin here</TopBarContainer>
				<form method="POST" action="/api/login">
					<input type="text" id="username" name="username" />
					<input type="text" id="password" name="password" />
					<input type="submit" value="nice" />
				</form>
			</Content>
		</Container>
	);
};
