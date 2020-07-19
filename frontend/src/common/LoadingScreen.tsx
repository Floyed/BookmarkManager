import React from "react";
import {CircularProgress, Typography} from "@material-ui/core";
import {createStyles, Theme, makeStyles} from '@material-ui/core/styles';
import {Spacer} from "./Spacer";

/**
 * Displays a centered, spinning wheel that says "Fetching data..." underneath.
 */

const useStyles = makeStyles((theme: Theme) =>
    createStyles({
        loadingScreen: {
            width: "100%",
            height: "100%",
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            flexDirection: "column"
        }
    }),
);

export default function LoadingScreen() {
    
    const classes = useStyles();

    return (
        <div className={classes.loadingScreen}>
            <CircularProgress/>
            <Spacer size={8}/>
            <Typography>Fetching data...</Typography>
        </div>
    )
}