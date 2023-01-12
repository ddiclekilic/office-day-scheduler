// assets
import KeyboardArrowRightIcon from '@mui/icons-material/KeyboardArrowRight';
// constant
const icons = { KeyboardArrowRightIcon };

// ==============================|| SCHEDULE MENU ITEMS ||============================== //

const schedule = {
    id: 'schedule-group',
    type: 'group',
    children: [
        {
            id: 'schedule',
            title: 'Schedule List',
            type: 'item',
            url: '/admin/schedule',
            icon: icons.KeyboardArrowRightIcon,
            breadcrumbs: false
        }
    ]
};

export default schedule;