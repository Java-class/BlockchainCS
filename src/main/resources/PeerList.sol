pragma solidity ^0.5.6;

contract PeerList {
  uint public peerCount = 0;
  enum STATUS {ACTIVE,BLOCKED,SUSPENDED}
  STATUS constant defaultStatue = STATUS.ACTIVE;

  struct Peer {
    uint id;
    string public_address;
    int256 totalSpace;
    int256 maxBandwidth;
    int256 maxUser;
    int uptimePercentage;
    string availableTimeRange;
    string description;
    string date;
    STATUS status;
  }


  mapping(uint => Peer) public peers;

  event PeerCreated(
    uint id,
    string public_address,
    int256 totalSpace,
    int256 maxBandwidth,
    int256 maxUser,
    int uptimePercentage,
    string availableTimeRange,
    string description,
    string date,
    STATUS status
  );

  function registerPeer(string memory _address, int256  _totalSpace, int256 _maxBandwidth, int256 _maxUser, int _uptimePercentage,string memory _availableTimeRange , string memory _description, string memory _date, STATUS _status) public {
    peerCount ++;
    peers[peerCount] = Peer(peerCount, _address, _totalSpace, _maxBandwidth, _maxUser, _uptimePercentage, _availableTimeRange , _description, _date, _status);
    emit PeerCreated(peerCount, _address, _totalSpace, _maxBandwidth, _maxUser, _uptimePercentage, _availableTimeRange, _description, _date, _status);
  }


  function updatePublicAddress(uint _index, string memory _newAddress) public returns (bool success) {
    if(isExists(_index)){
      Peer storage peer = peers[_index];
      peer.public_address = _newAddress;
      return true;
    }
    return false;
  }

  function isExists(uint _index) public view returns (bool) {
    if(peers[_index].id != 0){
      return true;
    }
    return false;
  }

}
