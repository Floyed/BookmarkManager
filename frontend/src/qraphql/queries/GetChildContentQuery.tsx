import { gql } from "apollo-boost";
import React from "react";
import { Query } from "react-apollo";
import {QueryResult} from "@apollo/react-common";
import { handleLoadingAndErrors } from "./HandleLoadingAndErrors";
import FolderInfo from "../../model/FolderInfo";
import Bookmark from "../../model/Bookmark";


const GET_CHILD_CONTENT = gql`
query getRootContent($folderId : ID!) {
  getFoldersInFolder(folderId : $folderId) {
    id
    name
  }
  getBookmarksInFolder(folderId : $folderId) {
    id
    name
    url
  }
}
`;

interface Data {
    getFoldersInFolder: Array<{
      id: string;
      name: string;
      status: string;
    }>;
    getBookmarksInFolder: Array<{
      id: string;
      status:string;
      name: string;
      url: string;
    }>;
  }

interface Variables {
    folderId : string
}   
  
  export function GetChildContentQuery( props : { variables: Variables }) : React.ReactElement{

    return (
      <Query<Data, Variables> query={GET_CHILD_CONTENT} variables={props.variables}>
        
        {({ loading, error, data }) => {
          
          if (data === undefined || error || loading) {
            return handleLoadingAndErrors(loading, error, data);
          }

          let content = data.getFoldersInFolder.map(
            f => (<FolderInfo key={f.id} {...f}  />)
          );

          data.getBookmarksInFolder.map(
            b => (content.push(<Bookmark key={b.id} {...b}  />))
          );

          return (
            <React.Fragment>
              {content}
            </React.Fragment>);
          }}
        
      </Query>
    );
  }

