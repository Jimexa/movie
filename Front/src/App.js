import React from "react";
import { Provider } from "react-redux";

import MainApp from "./components/mainApp/MainApp";
import store from "./store";

class App extends React.Component {
  state = { add: true };

  switch = () => {
    this.setState({ add: !this.state.add });
  };

  render() {
    return (
      <Provider store={store}>
        <MainApp />
      </Provider>
    );
  }
}

export default App;
