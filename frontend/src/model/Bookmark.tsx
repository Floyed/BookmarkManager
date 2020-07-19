import React, { ReactFragment } from "react";
import TreeItem from "@material-ui/lab/TreeItem";


interface Props {
    id: string;
    name: string;
    url: string
}

interface State {
    id: string;
    name: string;
    url: string
}

export default class Bookmark extends React.Component<Props, State>{

    state = {
        id: this.props.id,
        name: this.props.name,
        url: this.props.url
    };

    render() : React.ReactElement {

        return(
            <React.Fragment>
                <TreeItem nodeId="1" label={this.props.name}/>  
            </React.Fragment>
        );
    }

}
