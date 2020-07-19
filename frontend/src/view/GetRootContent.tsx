import React from "react";
import Bookmark from "../model/Bookmark";
import { makeStyles } from '@material-ui/core/styles';
import TreeView from '@material-ui/lab/TreeView';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import ChevronRightIcon from '@material-ui/icons/ChevronRight';

import { GetRootContentMutation } from "../qraphql/queries/GetRootContentQuery";
import FolderInfo from "../model/FolderInfo";
import { handleLoadingAndErrors } from "../qraphql/queries/HandleLoadingAndErrors";


const useStyles = makeStyles({
  root: {
    height: 240,
    flexGrow: 1,
    maxWidth: 400,
  },
});

export function GetRootContent(): React.ReactElement {

  const classes = useStyles();

  return (

    <React.Fragment>
      <TreeView className={classes.root} defaultCollapseIcon={<ExpandMoreIcon />} defaultExpandIcon={<ChevronRightIcon />}>
        <GetRootContentMutation>
          {
            ({ loading, error, data }) => {

              if (data === undefined || error || loading) {
                return handleLoadingAndErrors(loading, error, data);
              }

              let contents = data.getRootFolders.map(
                f => (<FolderInfo key={f.id} {...f}  />)
              );

              data.getRootBookmarks.map(
                b => (contents.push(<Bookmark key={b.id} {...b} />))
              );

              return (<div>{contents}</div>);
            }
          }
        </GetRootContentMutation>
      </TreeView>
    </React.Fragment>

  );
}
