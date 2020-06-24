import React, { useState } from "react";
import styled from "styled-components";

import { NavigationMenu } from "../components/NavigationMenu/NavigationMenu";
import { TopBarContainer } from "../components/TopBarContainer";
import { PRIMARY_BACKGROUND_COLOR, PRIMARY_TEXT_COLOR } from "../constants";
import { SearchBar } from "../components/Input/SearchBar";
import { CustomButton } from "../components/Input/CustomButton";

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
	padding: 0 1rem;
`;

export const Homepage = () => {
	const searchBarInitialValue = "";
	const [searchValue, setsearchValue] = useState(searchBarInitialValue);
	return (
		<Container>
			<NavigationMenu />
			<Content>
				<TopBarContainer>
					<VerticalAlign>
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
					</VerticalAlign>
				</TopBarContainer>
			</Content>
		</Container>
	);
};
