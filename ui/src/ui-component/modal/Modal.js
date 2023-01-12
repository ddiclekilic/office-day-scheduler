import React from 'react'
import { createTheme, ThemeProvider, Button, TextField, Modal, Box, Divider } from "@mui/material";
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Typography from '@mui/material/Typography';

function MyModal({setOpenModal}) {
    const [updateOpen, setUpdateOpen] = useState(false);
    const [createOpen, setCreateOpen]=useState(false);
    const style = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        width: 500,
        bgcolor: 'background.paper',
        border: '2px solid #FFFFFF',
        boxShadow: 24,
        p: 2,
      };
    return(
    <div>
      <div>
        <button
          onClick={() => {
            setOpenModal(false);
          }}
        >
          X
        </button>
      </div>
      <Modal
          open={updateOpen}
          onClose={handleUpdateClose} 
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
          <Card sx={{margin:2, maxWidth: 500 }}>
        <CardHeader align="left"
        /> 
        <CardContent>
        <h3>Edit Role</h3>
          <TextField id="outlined-basic" name="roleName" label="Role Name" variant="outlined" /*  value={roleName} */ 
          /* onChange={(e) => onInputChange(e)} *//>
          <Button variant="outlined" style={{marginLeft:30, marginTop:10}} /* onClick={()=> handleUpdate()} */>Save</Button> 
          <Typography variant="body2" color="text.secondary" align="left">
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
        </CardActions>
      </Card>
          </Box>
        </Modal>
  </div>
  );
    /* const {isOpen}=props;
    const [open, setOpen] = React.useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    const style = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        width: 400,
        bgcolor: 'background.paper',
        border: '2px solid #000',
        boxShadow: 24,
        p: 4,
      };

  return (
    <div>
    <Button onClick={handleOpen}>Open modal</Button>
    <Modal
      open={isOpen}
      onClose={handleClose}
      aria-labelledby="modal-modal-title"
      aria-describedby="modal-modal-description"
    >
      <Box sx={style}>
        <Typography id="modal-modal-title" variant="h6" component="h2">
          Text in a modal
        </Typography>
        <Typography id="modal-modal-description" sx={{ mt: 2 }}>
          Duis mollis, est non commodo luctus, nisi erat porttitor ligula.
        </Typography>
      </Box>
    </Modal>
  </div>
  ) */
}

export default MyModal;
