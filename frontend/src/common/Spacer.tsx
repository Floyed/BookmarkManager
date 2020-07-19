import React from "react";

interface Props {
    size: number
}

/**
 * Adds some vertical space.
 * @param props set the size to the preferred height in `px`
 */
export function Spacer(props: Props) {
    return <div style={{height: props.size}}/>
}