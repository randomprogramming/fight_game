import React from "react";
import styled from "styled-components";

import { TOP_BAR_HEIGHT, TOP_BAR_COLOR } from "../constants";

const Container = styled.div`
	height: ${TOP_BAR_HEIGHT};
	background-color: ${TOP_BAR_COLOR};
	-webkit-box-shadow: 0px 7px 12px 0px rgba(0, 0, 0, 0.63);
	-moz-box-shadow: 0px 7px 12px 0px rgba(0, 0, 0, 0.63);
	box-shadow: 0px 7px 12px 0px rgba(0, 0, 0, 0.63);
	z-index: 1;
`;

export const TopBarContainer = (props) => {
	return <Container>{props.children}</Container>;
};
