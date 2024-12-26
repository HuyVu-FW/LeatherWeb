import { FC, PropsWithChildren } from "react";
import { Box } from "@mui/material";


const DocsLayout: FC<PropsWithChildren> = ({ children }) => {
  return (
    <Box>
  

      {children}
    </Box>
  );
};

export default DocsLayout;
