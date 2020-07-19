import React from "react";
import Bookmark from "./Bookmark";
import TreeItem from '@material-ui/lab/TreeItem';


interface Props {
    id: string;
    name: string;
}

interface State {
    id: string;
    name: string;
    childFolders: Array<Folder> | null;
    childBookmarks: Array<Bookmark> | null
}

export default class Folder extends React.Component<Props, State>{

    state = {
        id : this.props.id,
        name : this.props.name,
        childFolders: [],
        childBookmarks: []
    };

    render() {
        return (
            <React.Fragment>
                <TreeItem nodeId="1" label={this.props.name} />  
            </React.Fragment>
        );
    }
}