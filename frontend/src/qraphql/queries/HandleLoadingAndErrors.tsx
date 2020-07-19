import {ApolloError} from "apollo-boost";
import LoadingScreen from "../../common/LoadingScreen";
import Typography from "@material-ui/core/Typography";
import React from "react";

export function handleLoadingAndErrors(loading: boolean, error: ApolloError | undefined, data: any): JSX.Element | null {
    if (loading) {
        return <LoadingScreen/>
    }

    if (error) {
        return (
            <div style={{padding: 16}}>
                <Typography>An error has occurred. Here are some steps to try and fix it:</Typography>
                <ul>
                    <li><Typography>Reload the webpage</Typography></li>
                    <li><Typography>Log out and log back in</Typography></li>
                    <li><Typography>Try loading the page in an Incognito/Private Browsing window</Typography></li>
                    <li><Typography>Try using a different browser, or updating your current browser</Typography></li>
                </ul>
                <pre>
                    {JSON.stringify(error, null, 2)}
                </pre>
            </div>
        )
    }

    if (data === undefined) {
        return (
            <Typography>No data was loaded. This shouldn't be possible. Please file a bug report.</Typography>
        )
    }

    return null;
}