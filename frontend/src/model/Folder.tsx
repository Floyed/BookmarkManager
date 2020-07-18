import React from "react";
import Bookmark from "./Bookmark";

interface Props {
    id: string;
    status: string;
    name: string;
}

interface State {
    id: string;
    status: string;
    name: string;
    childFolders: Array<Folder> | null;
    childBookmarks: Array<Bookmark> | null
}

export default class Folder extends React.Component<Props, State>{

    state = {
        id : this.props.id,
        status : this.props.status,
        name : this.props.name,
        childFolders: [],
        childBookmarks: []
    };

    render() {
        return (
            <div>
                {this.props.name} {this.props.status}
            </div>
        );
    }
}