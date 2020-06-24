import React from "react";
import styled from "styled-components";
import { useSelector } from "react-redux";

import { SECONDARY_BACKGROUND_COLOR, ACCENT_COLOR_DARK_PURPLE } from "../../constants";
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
		font-size: 26px;
		margin-top: 2rem;
	}
`;

const InnerListContainer = styled.ol`
	list-style-type: none;
	margin-top: 0.6rem;
	margin-left: 1rem;
	font-size: 22px;
	color: ${ACCENT_COLOR_DARK_PURPLE};
`;

const NavigationContentContainer = styled.div`
	background-color: ${SECONDARY_BACKGROUND_COLOR};
	flex: 1;
	padding: 1.5rem;
`;

export const NavigationMenu = () => {
	const playerUsername = useSelector((state) => state.PlayerReducer["username"]);
	const playerImageURL = useSelector((state) => state.PlayerReducer["characterImageURL"]);

	return (
		<Container>
			<TopBarContainer>Fight Game</TopBarContainer>
			<NavigationContentContainer>
				<ListContainer>
					<li className="large-list-item">Profile</li>
					<InnerListContainer>
						<li style={{ position: "relative" }}>
							<img
								src={playerImageURL}
								style={{
									width: "auto",
									height: "100%",
									position: "absolute",
									left: "-1.7em",
									borderRadius: "50%",
								}}
							/>
							{playerUsername}
						</li>
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
