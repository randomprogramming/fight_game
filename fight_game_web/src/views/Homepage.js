import React from "react";
import styled from "styled-components";

import { NavigationMenu } from "../components/NavigationMenu/NavigationMenu";
import { TopBarContainer } from "../components/TopBarContainer";
import { PRIMARY_BACKGROUND_COLOR } from "../constants";
import { SearchBar } from "../components/Input/SearchBar";

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

const VerticalAlign = styled.div`
	height: 100%;
	display: flex;
	flex-direction: row;
	align-items: center;
`;

export const Homepage = () => {
	return (
		<Container>
			<NavigationMenu />
			<Content>
				<TopBarContainer>
					<VerticalAlign>
						<SearchBar />
					</VerticalAlign>
				</TopBarContainer>
			</Content>
		</Container>
	);
};
