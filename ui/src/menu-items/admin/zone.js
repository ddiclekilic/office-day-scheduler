// assets
import KeyboardArrowRightIcon from '@mui/icons-material/KeyboardArrowRight';
// constant
const icons = { KeyboardArrowRightIcon };

// ==============================|| ZONE MENU ITEMS ||============================== //

const zone = {
    id: 'zone-group',
    type: 'group',
    children: [
        {
            id: 'zone',
            title: 'Zone List',
            type: 'item',
            url: '/admin/zone',
            icon: icons.KeyboardArrowRightIcon,
            breadcrumbs: false
        }
    ]
};

export default zone;
