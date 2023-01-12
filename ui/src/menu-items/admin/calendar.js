// assets
import KeyboardArrowRightIcon from '@mui/icons-material/KeyboardArrowRight';
// constant
const icons = { KeyboardArrowRightIcon };

// ==============================|| CALENDAR MENU ITEMS ||============================== //

const calendar = {
    id: 'calendar-group',
    type: 'group',
    children: [
        {
            id: 'calendar',
            title: 'Calendar List',
            type: 'item',
            url: '/admin/calendar',
            icon: icons.KeyboardArrowRightIcon,
            breadcrumbs: false
        }
    ]
};

export default calendar;
