import React from "react";
import styled from "styled-components";

import { NavigationMenu } from "../components/NavigationMenu/NavigationMenu";
import { TopBarContainer } from "../components/TopBarContainer";

const Container = styled.div`
	display: flex;
	flex-direction: row;
	height: 100%;
`;

const Content = styled.div`
	flex: 1;
`;

export const Homepage = () => {
	return (
		<Container>
			<NavigationMenu />
			<Content>
				<TopBarContainer>Give left margin here</TopBarContainer>
			</Content>
		</Container>
	);
};
