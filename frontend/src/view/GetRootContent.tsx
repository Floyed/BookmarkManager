import { gql } from "apollo-boost";
import { Query, useQuery } from "react-apollo";
import React from "react";
import Folder from "../model/Folder";
import Bookmark from "../model/Bookmark";

import { GetRootContentMutation } from "../qraphql/queries/GetRootContentQuery";

const GET_ROOT_CONTENT = gql`
  query getRootContent {
    getRootFolders {
      id
      name
    }
    getRootBookmarks {
      id
      name
      url
    }
  }
`;

interface Data {
  getRootFolders: Array<{
    id: string;
    name: string;
  }>;
  getRootBookmarks: Array<{
    id: string;
    name: string;
    url: string;
  }>;
}


export function GetRootContent() : React.ReactElement{

  return (
      <GetRootContentMutation>
        {
          ({loading, error, data}) => {
            
            if(data === undefined){
              return (<div>abc</div>);
            }
            console.log(data);
            
            let bookmarks = data.getRootBookmarks.map(
            b => (<Bookmark id = {b.id} name = {b.name} url = {b.url} status = {b.status}></Bookmark>)
            );

            data.getRootFolders.map(
              f => (bookmarks.push(<Folder id = {f.id} name = {f.name} status = {f.status}></Folder>))
            )
            
            return (<div>{bookmarks}</div>);
        }
      }
      </GetRootContentMutation>
  );
}
