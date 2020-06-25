import React from "react";
import styled from "styled-components";

import { ACCENT_COLOR_LIGHT_BLUE, PRIMARY_BACKGROUND_COLOR } from "../../constants";

const Button = styled.button`
	background-color: ${ACCENT_COLOR_LIGHT_BLUE};
	color: ${PRIMARY_BACKGROUND_COLOR};
	cursor: pointer;
	outline: none;
	border: none;
	font-family: inherit;
	padding: 5px 1.5rem;
	border-radius: 14px;
	font-size: 18px;
	box-shadow: 0px 1px 15px 1px rgba(60, 252, 239, 0.5);
	transition: 0.2s ease-in-out;
	&:hover {
		transform: scale(1.05);
	}
`;

export const CustomButton = () => {
	return <Button onClick={(e) => console.log("clicked")}>Search</Button>;
};
