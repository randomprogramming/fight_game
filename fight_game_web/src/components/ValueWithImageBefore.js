import React from "react";

export const ValueWithImageBefore = (props) => {
	return (
		<div
			style={{
				display: "flex",
				flexDirection: "row",
				height: "100%",
				alignItems: "center",
				margin: "0 0.5em",
			}}
		>
			<img src={props.imageURL} style={{ height: "75%", width: "auto" }} />
			<span style={{ marginLeft: "0.5em" }}>{props.value}</span>
		</div>
	);
};
