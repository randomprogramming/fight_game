import React from "react";
import styled from "styled-components";

import { TOP_BAR_HEIGHT, TOP_BAR_COLOR } from "../constants";

const Container = styled.div`
	height: ${TOP_BAR_HEIGHT};
	background-color: ${TOP_BAR_COLOR};
`;

export const TopBarContainer = (props) => {
	return <Container>{props.children}</Container>;
};
