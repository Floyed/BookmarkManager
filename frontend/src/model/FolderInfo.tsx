import React, { useState } from "react";
import TreeView from "@material-ui/lab/TreeView";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import ChevronRightIcon from "@material-ui/icons/ChevronRight";
import TreeItem from "@material-ui/lab/TreeItem";
import { GetChildContentQuery } from "../qraphql/queries/GetChildContentQuery";

export default function FolderInfo(props: { id: string; name: string}) {

    const [childNodes, setChildNodes] = useState<React.ReactElement>();
    const [expanded, setExpanded] = React.useState<string[]>([]);

    const handleChange = (event : object, nodes : string[]) => {
        const expandingNodes = nodes.filter((x: string) => !expanded.includes(x));
        setExpanded(nodes);
        if (expandingNodes[0]) {
          const childId = expandingNodes[0];

          setChildNodes(
            <GetChildContentQuery variables = {{folderId : childId}} />
          )
        }
    };

    return (
        <TreeView
            defaultCollapseIcon={<ExpandMoreIcon />}
            defaultExpandIcon={<ChevronRightIcon />}
            expanded={expanded}
            onNodeToggle={handleChange}
        >
            {/*The node below should act as the root node for now */}
            <TreeItem nodeId={props.id} label={props.name}>
                {childNodes || [<div key="stub" />]}
            </TreeItem>
        </TreeView>
    );
}