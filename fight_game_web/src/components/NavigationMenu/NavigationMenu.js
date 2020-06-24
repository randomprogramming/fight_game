import React from "react";
import styled from "styled-components";

import { SECONDARY_BACKGROUND_COLOR } from "../../constants";
import { TopBarContainer } from "../TopBarContainer";

const Container = styled.div`
	min-width: 18%;
	display: flex;
	flex-direction: column;
`;

const ListContainer = styled.ol`
	padding: 0;
	margin: 0;
	list-style-type: none;
	& > .large-list-item {
		font-size: 24px;
		margin-top: 2rem;
	}
`;

const InnerListContainer = styled.ol`
	list-style-type: none;
	margin-top: 0.3rem;
`;

const NavigationContentContainer = styled.div`
	background-color: ${SECONDARY_BACKGROUND_COLOR};
	flex: 1;
	padding: 1rem;
`;

export const NavigationMenu = () => {
	return (
		<Container>
			<TopBarContainer>Fight Game</TopBarContainer>
			<NavigationContentContainer>
				<ListContainer>
					<li className="large-list-item">Profile</li>
					<InnerListContainer>
						{/* TODO: Put logged in player username here */}
						<li>Hieui</li>
					</InnerListContainer>
					<li className="large-list-item">Lorem</li>
					<InnerListContainer>
						<li>Ipsum</li>
					</InnerListContainer>
					<li className="large-list-item">Lorem 2</li>
					<InnerListContainer>
						<li>Ipsum 2</li>
					</InnerListContainer>
				</ListContainer>
			</NavigationContentContainer>
		</Container>
	);
};
