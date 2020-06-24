import React, { useState } from "react";

export const SearchBar = () => {
	const [searchInput, setsearchInput] = useState("");

	return (
		<div>
			<input
				value={searchInput}
				onChange={(e) => {
					setsearchInput(e.target.value);
				}}
			/>
		</div>
	);
};
