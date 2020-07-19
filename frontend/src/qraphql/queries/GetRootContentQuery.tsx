import { gql } from "apollo-boost";
import React from "react";
import { Query } from "react-apollo";
import {QueryResult} from "@apollo/react-common";


const GET_ROOT_CONTENT = gql`
query getRootContent {
  getRootFolders {
    id
    name
    parentFolder {
      id
    }
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
      status: string;
      parentFolder: {
        id: string
      };
    }>;
    getRootBookmarks: Array<{
      id: string;
      status:string;
      name: string;
      url: string;
    }>;
  }

  interface Variables {
    }
  
  export function GetRootContentMutation( props : { children : (result: QueryResult<Data, Variables>) => JSX.Element | null }) : React.ReactElement{

    return (
      <Query<Data, Variables> query={GET_ROOT_CONTENT}>
        {props.children}
      </Query>
    );
  }

