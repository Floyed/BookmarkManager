import React, { ReactFragment } from "react";
import ReactDOM from "react-dom";


interface Props {
    id: string;
    status: string;
    name: string;
    url: string
}

interface State {
    id: string;
    status: string;
    name: string;
    url: string
}

export default class Bookmark extends React.Component<Props, State>{

    state = {
        id: this.props.id,
        status: this.props.status,
        name: this.props.name,
        url: this.props.url
    };

public static fromJSON(json : any): Bookmark {
    let bookmark = Object.create(Bookmark.prototype);

    return Object.assign(bookmark, json, {
        id : json.id,
        status: json.status,
        name: json.name,
        url: json.url
    });
}

    render() : React.ReactElement {

        return(
            <div>
                {this.state.name} {this.state.url}
            </div>
        );
    }

}

// export function GetBookmarkInfo(props : {bookmarkInfo : Bookmark}) : React.ReactElement{
//     return(
//         <div>
//             {props.bookmarkInfo.name} {props.bookmarkInfo.url}
//         </div>
//     );  
// }