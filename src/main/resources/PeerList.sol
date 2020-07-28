pragma solidity ^0.5.6;

contract PeerList {
  uint public peerCount = 0;
  enum STATUS {ACTIVE,BLOCKED,SUSPENDED}
  STATUS constant defaultStatue = STATUS.ACTIVE;

  struct Peer {
    uint id;
    address owner;
    string public_url;
    int256 totalSpace;
    int256 usedSpace;
    int256 maxBandwidth;
    int256 maxUser;
    int uptimePercentage;
    string availableTimeRange;
    string date;
    STATUS status;
  }


  mapping(uint => Peer) public peers;

  event PeerCreated(
    uint id,
    address owner,
    string public_url,
    int256 totalSpace,
    int256 usedSpace,
    int256 maxBandwidth,
    int256 maxUser,
    int uptimePercentage,
    string availableTimeRange,
    string date,
    STATUS status
  );

  function registerPeer(string memory _url, int256  _totalSpace, int256 _maxBandwidth, int256 _maxUser, int _uptimePercentage, string memory _availableTimeRange,  string memory _date, STATUS _status) public {
    address owner = msg.sender;
    peerCount ++;
    peers[peerCount] = Peer(peerCount, owner, _url, _totalSpace,0, _maxBandwidth, _maxUser, _uptimePercentage, _availableTimeRange , _date, _status);
    emit PeerCreated(peerCount, owner, _url, _totalSpace,0, _maxBandwidth, _maxUser, _uptimePercentage, _availableTimeRange , _date, _status);
  }


  function updatePublicUrl(uint _index, string memory _newUrl) public returns (bool success) {
    if(isExists(_index)){
      Peer storage peer = peers[_index];
      peer.public_url = _newUrl;
      return true;
    }
    return false;
  }

  function updateUsedSpace(uint _index, int256 _usedSpace) public returns (bool success) {
    if(isExists(_index)){
      Peer storage peer = peers[_index];
      peer.usedSpace = _usedSpace;
      return true;
    }
    return false;
  }

  function updateMaxBandwidth(uint _index, int256 _maxBandwidth) public returns (bool success) {
    if(isExists(_index)){
      Peer storage peer = peers[_index];
      peer.maxBandwidth = _maxBandwidth;
      return true;
    }
    return false;
  }

  function updateMaxUser(uint _index, int256 _maxUser) public returns (bool success) {
    if(isExists(_index)){
      Peer storage peer = peers[_index];
      peer.maxUser = _maxUser;
      return true;
    }
    return false;
  }

  function updateUpTimePercentage(uint _index, int _uptime) public returns (bool success) {
    if(isExists(_index)){
      Peer storage peer = peers[_index];
      peer.uptimePercentage = _uptime;
      return true;
    }
    return false;
  }

  function updateAvailableTimeRange(uint _index, string memory _timeRange) public returns (bool success) {
    if(isExists(_index)){
      Peer storage peer = peers[_index];
      peer.availableTimeRange = _timeRange;
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
