import React, { useState, useEffect } from "react";

export const SearchBar = (props) => {
	const [searchInput, setsearchInput] = useState(props.initialValue);

	useEffect(() => {
		props.onChange(searchInput);
	}, [searchInput]);

	return (
		<input
			value={searchInput}
			placeholder={props.placeholder}
			style={{
				...props.style,
				fontFamily: "inherit",
				border: "none",
				width: props.width,
				textAlign: "center",
			}}
			onChange={(e) => {
				setsearchInput(e.target.value);
			}}
		/>
	);
};
