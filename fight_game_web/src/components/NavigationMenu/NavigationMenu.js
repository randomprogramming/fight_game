import React from "react";
import styled from "styled-components";

import { SECONDARY_BACKGROUND_COLOR } from "../../constants";
import { TopBarContainer } from "../TopBarContainer";

const Container = styled.div`
	min-width: 20%;
	display: flex;
	flex-direction: column;
`;

const NavigationContentContainer = styled.div`
	background-color: ${SECONDARY_BACKGROUND_COLOR};
	flex: 1;
`;

export const NavigationMenu = () => {
	return (
		<Container>
			<TopBarContainer>Fight Game</TopBarContainer>
			<NavigationContentContainer>content</NavigationContentContainer>
		</Container>
	);
};
