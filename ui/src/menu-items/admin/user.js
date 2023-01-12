// assets
import KeyboardArrowRightIcon from '@mui/icons-material/KeyboardArrowRight';
// constant
const icons = { KeyboardArrowRightIcon };

// ==============================|| USER MENU ITEMS ||============================== //

const user = {
    id: 'user-group',
    type: 'group',
    children: [
        {
            id: 'user',
            title: 'User List',
            type: 'item',
            url: '/admin/user-list',
            icon: icons.KeyboardArrowRightIcon,
            breadcrumbs: false
        }
    ]
};

export default user;
