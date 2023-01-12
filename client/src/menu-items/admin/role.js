// assets
import KeyboardArrowRightIcon from '@mui/icons-material/KeyboardArrowRight';
// constant
const icons = { KeyboardArrowRightIcon };

// ==============================|| ROLE MENU ITEMS ||============================== //

const role = {
    id: 'role-group',
    type: 'group',
    children: [
        {
            id: 'role',
            title: 'Role List',
            type: 'item',
            url: '/admin/role',
            icon: icons.KeyboardArrowRightIcon,
            breadcrumbs: false
        }
    ]
};

export default role;
