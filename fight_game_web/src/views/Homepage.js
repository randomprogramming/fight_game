import React, { useState } from "react";
import styled from "styled-components";
import { useSelector } from "react-redux";

import { NavigationMenu } from "../components/NavigationMenu/NavigationMenu";
import { TopBarContainer } from "../components/TopBarContainer";
import {
	PRIMARY_BACKGROUND_COLOR,
	PRIMARY_TEXT_COLOR,
	GOLD_COIN_IMAGE_URL,
	PREMIUM_COIN_IMAGE_URL,
} from "../constants";
import { SearchBar } from "../components/Input/SearchBar";
import { CustomButton } from "../components/Input/CustomButton";
import { VerticalBar } from "../components/VerticalBar";
import { ValueWithImageBefore } from "../components/ValueWithImageBefore";
import { LogoutButton } from "../components/Input/LogoutButton";

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
	justify-content: space-between;
	padding: 0 1rem;
`;

const TopBarSmallContainer = styled.div`
	height: 100%;
	display: flex;
	flex-direction: row;
	align-items: center;
`;

export const Homepage = () => {
	const searchBarInitialValue = "";
	const [searchValue, setsearchValue] = useState(searchBarInitialValue);

	const playerUsername = useSelector((state) => state.PlayerReducer["username"]);
	const playerImageURL = useSelector((state) => state.PlayerReducer["characterImageURL"]);
	const playerCurrency = useSelector((state) => state.PlayerReducer["currency"]);
	const playerPremiumCurrency = useSelector((state) => state.PlayerReducer["premiumCurrency"]);

	return (
		<Container>
			<NavigationMenu />
			<Content>
				<TopBarContainer>
					<VerticalAlign>
						<TopBarSmallContainer>
							<SearchBar
								initialValue={searchBarInitialValue}
								onChange={(newInput) => setsearchValue(newInput)}
								placeholder={"Search for other players or guilds..."}
								width="300px"
								style={{
									backgroundColor: PRIMARY_BACKGROUND_COLOR,
									color: PRIMARY_TEXT_COLOR,
									padding: "10px 15px",
									borderRadius: "15px",
								}}
							/>
							<CustomButton />
						</TopBarSmallContainer>
						<VerticalBar />
						<TopBarSmallContainer>
							<ValueWithImageBefore imageURL={GOLD_COIN_IMAGE_URL} value={playerCurrency} />
							<ValueWithImageBefore
								imageURL={PREMIUM_COIN_IMAGE_URL}
								value={playerPremiumCurrency}
							/>
						</TopBarSmallContainer>
						<VerticalBar />
						<TopBarSmallContainer>
							<ValueWithImageBefore imageURL={playerImageURL} value={playerUsername} />
							<LogoutButton />
						</TopBarSmallContainer>
					</VerticalAlign>
				</TopBarContainer>
			</Content>
		</Container>
	);
};
