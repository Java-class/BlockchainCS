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


  mapping(address => Peer) public peers;
  address[] public publicAddress;

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
    peers[owner] = Peer(peerCount, owner, _url, _totalSpace,0, _maxBandwidth, _maxUser, _uptimePercentage, _availableTimeRange , _date, _status);
    publicAddress.push(owner);
    emit PeerCreated(peerCount, owner, _url, _totalSpace,0, _maxBandwidth, _maxUser, _uptimePercentage, _availableTimeRange , _date, _status);
  }

  function getPeerCount() public view returns (uint count){
    return peerCount;
  }

  function getPublicAddress() public view returns (address[] memory publicAdds) {
    return publicAddress;
  }


  function updatePublicUrl(string memory _newUrl) public returns (bool success) {
    if(isExists(msg.sender)){
      Peer storage peer = peers[msg.sender];
      if(peer.owner==msg.sender){
        peer.public_url = _newUrl;
        return true;
      }
    }
    return false;
  }

  function updateTotalSpace(int256 _totalSpace) public returns (bool success) {
    if(isExists(msg.sender)){
      Peer storage peer = peers[msg.sender];
      if(peer.owner==msg.sender){
        peer.totalSpace = _totalSpace;
        return true;
      }
    }
    return false;
  }


  function updateUsedSpace(int256 _usedSpace) public returns (bool success) {
    if(isExists(msg.sender)){
      Peer storage peer = peers[msg.sender];
      if(peer.owner==msg.sender){
        peer.usedSpace = _usedSpace;
        return true;
      }
    }
    return false;
  }

  function updateMaxBandwidth(int256 _maxBandwidth) public returns (bool success) {
    if(isExists(msg.sender)){
      Peer storage peer = peers[msg.sender];
      if(peer.owner==msg.sender){
        peer.maxBandwidth = _maxBandwidth;
        return true;
      }
    }
    return false;
  }

  function updateMaxUser(int256 _maxUser) public returns (bool success) {
    if(isExists(msg.sender)){
      Peer storage peer = peers[msg.sender];
      if(peer.owner==msg.sender){
        peer.maxUser = _maxUser;
        return true;
      }
    }
    return false;
  }

  function updateUpTimePercentage(int _uptime) public returns (bool success) {
    if(isExists(msg.sender)){
      Peer storage peer = peers[msg.sender];
      if(peer.owner==msg.sender){
        peer.uptimePercentage = _uptime;
        return true;
      }
    }
    return false;
  }

  function updateAvailableTimeRange(string memory _timeRange) public returns (bool success) {
    if(isExists(msg.sender)){
      Peer storage peer = peers[msg.sender];
      if(peer.owner==msg.sender){
        peer.availableTimeRange = _timeRange;
        return true;
      }
    }
    return false;
  }

  function isExists(address owner) public view returns (bool) {
    if(peers[owner].id != 0){
      return true;
    }
    return false;
  }

}
