import Link from "next/link";
import { FC, Fragment } from "react";
import { Box, Button, Divider } from "@mui/material";
import Image from "components/BazaarImage";
import { H6 } from "components/Typography";
import { FlexBox, FlexRowCenter } from "components/flex-box";
import { GoogleOAuthProvider, GoogleLogin } from '@react-oauth/google';
import FacebookLogin from 'react-facebook-login';

// =======================================
type SocialButtonsProps = {
  handleGoogle?: () => void;
  handleFacebook?: () => void;
};
// =======================================

const SocialButtons: FC<SocialButtonsProps> = ({ handleGoogle, handleFacebook }) => {
  return (
    <Fragment>
      <Box mb={3} mt={3.8}>
        <Box width="200px" mx="auto">
          <Divider />
        </Box>

        <FlexBox justifyContent="center" mt={-1.625}>
          <Box color="grey.600" bgcolor="background.paper" px={2}>
            or
          </Box>
        </FlexBox>
      </Box>

      {/* Button for Facebook Login */}
      {/* Facebook Login Button */}
      {/* <FacebookLogin
        appId={process.env.NEXT_PUBLIC_FACEBOOK_APP_ID}
        autoLoad={false}
        fields="name,email,picture"
        callback={()=>{}}
        render={(renderProps) => (
          <Button onClick={renderProps.onClick} fullWidth sx={{ height: 44 }}>
            Continue with Facebook
          </Button>
        )}
      /> */}
  


      <GoogleOAuthProvider clientId={process.env.NEXT_PUBLIC_GOOGLE_CLIENT_ID}>
        <GoogleLogin
          onSuccess={() => { console.log("Google") }}
          onError={() => { console.log("Google") }}
        />
      </GoogleOAuthProvider>
    </Fragment>
  );
};

export default SocialButtons;
