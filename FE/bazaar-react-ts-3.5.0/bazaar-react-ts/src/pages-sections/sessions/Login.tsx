import { useCallback, useState } from "react";
import { Button, Card, Box, styled } from "@mui/material";
import Link from "next/link";
import * as yup from "yup";
import { useFormik } from "formik";
import { H1, H6 } from "components/Typography";
import BazaarImage from "components/BazaarImage";
import BazaarTextField from "components/BazaarTextField";
import EyeToggleButton from "./EyeToggleButton";
import { FlexBox, FlexRowCenter } from "components/flex-box";
import { useRouter } from "next/router";


const fbStyle = { background: "#3B5998", color: "white" };
const googleStyle = { background: "#4285F4", color: "white" };

type WrapperProps = { passwordVisibility?: boolean };

export const Wrapper = styled(Card)<WrapperProps>(({ theme, passwordVisibility }) => ({
  width: 500,
  padding: "2rem 3rem",
  [theme.breakpoints.down("sm")]: { width: "100%" },
  ".passwordEye": {
    color: passwordVisibility ? theme.palette.grey[600] : theme.palette.grey[400],
  },
  ".facebookButton": { marginBottom: 10, ...fbStyle, "&:hover": fbStyle },
  ".googleButton": { ...googleStyle, "&:hover": googleStyle },
  ".agreement": { marginTop: 12, marginBottom: 24 },
}));

const Login = () => {
  const router = useRouter();

  const [passwordVisibility, setPasswordVisibility] = useState(false);

  const togglePasswordVisibility = useCallback(() => {
    setPasswordVisibility((visible) => !visible);
  }, []);

  const handleFormSubmit = async (values: any) => {
    try {
      const response = await fetch("http://localhost:8080/auth/login/", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(values),

      });

      if (!response.ok) {
        throw new Error("Network response was not ok");
      }

      const data = await response.json();
      console.log("Login successful:", data);
      router.push("/");
      // Handle successful login, e.g., save token, redirect, etc.
    } catch (error) {
      console.error("Login failed:", error);
      // Handle login failure, e.g., show error message
    }
  };

  const { values, errors, touched, handleBlur, handleChange, handleSubmit } =
    useFormik({
      initialValues,
      onSubmit: handleFormSubmit,
      validationSchema: formSchema,
    });

  return (
    <Wrapper elevation={3} passwordVisibility={passwordVisibility}>
      <form onSubmit={handleSubmit}>
        <BazaarImage
          src="/assets/images/bazaar-black-sm.svg"
          sx={{ m: "auto" }}
        />

        <H1 textAlign="center" mt={1} mb={4} fontSize={16}>
          Welcome To My Store
        </H1>

        <BazaarTextField
          mb={1.5}
          fullWidth
          size="small"
          type="text"
          name="username"
          variant="outlined"
          onBlur={handleBlur}
          value={values.username}
          onChange={handleChange}
          label="Username or Phone Number"
          placeholder="example@mail.com"
          error={!!touched.username && !!errors.username}
          helperText={(touched.username && errors.username) as string}
        />

        <BazaarTextField
          mb={2}
          fullWidth
          size="small"
          name="password"
          label="Password"
          autoComplete="on"
          variant="outlined"
          onBlur={handleBlur}
          onChange={handleChange}
          value={values.password}
          placeholder="*********"
          type={passwordVisibility ? "text" : "password"}
          error={!!touched.password && !!errors.password}
          helperText={(touched.password && errors.password) as string}
          InputProps={{
            endAdornment: (
              <EyeToggleButton
                show={passwordVisibility}
                click={togglePasswordVisibility}
              />
            ),
          }}
        />

        <Button
          fullWidth
          type="submit"
          color="primary"
          variant="contained"
          sx={{ height: 44 }}
        >
          Login
        </Button>
      </form>

      <FlexRowCenter mt="1.25rem">
        <Box>Don&apos;t have an account?</Box>
        <Link href="/signup">
          <H6 ml={1} borderBottom="1px solid" borderColor="grey.900">
            Sign Up
          </H6>
        </Link>
      </FlexRowCenter>

      <FlexBox
        justifyContent="center"
        bgcolor="grey.200"
        borderRadius="4px"
        py={2.5}
        mt="1.25rem"
      >
        Forgot your password?
        <Link href="/reset-password">
          <H6 ml={1} borderBottom="1px solid" borderColor="grey.900">
            Reset It
          </H6>
        </Link>
      </FlexBox>
    </Wrapper>
  );
};

const initialValues = { username: "", password: "" };

const formSchema = yup.object().shape({
  username: yup.string().required("Username is required"),
  password: yup.string().required("Password is required"),
});

export default Login;
