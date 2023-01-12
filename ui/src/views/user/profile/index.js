import React, {useState, useEffect} from 'react'
import ProfileCard from '../../../ui-component/cards/ProfileCard';
import UserService from 'services/user/UserService';
import ServiceCaller from 'services/ServiceCaller';
function Profile() {
  return (
    <div>
      <h2>Profile</h2>
      <ProfileCard> </ProfileCard>
     </div>
  ) 
}

export default Profile;
