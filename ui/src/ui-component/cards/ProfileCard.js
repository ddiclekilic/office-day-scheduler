import * as React from 'react';
import Box from '@mui/material/Box';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

function OutlinedCard() {
return (
    <Box sx={{ width: 500, height:200, backgroundColor:'white' }}>
      <React.Fragment>
      <CardContent>
        <Typography variant="body2">
          Name: 
        </Typography>
        <Typography variant="body2">
          Surname: 
        </Typography>
        <Typography variant="body2">
          Registration Number: 
        </Typography>
        <Typography variant="body2">
          Email:
        </Typography>
      </CardContent>
    </React.Fragment>
    </Box>
  );
}

export default OutlinedCard;