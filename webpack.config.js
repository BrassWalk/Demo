module.exports = {
  entry: './src/client/app.tsx',
  output: {
    filename: './dist/bundle.js'
  },
  resolve: {
    extensions: [".ts", ".tsx", ".js", ".jsx"]
  },
  loaders: [
      { test: /\.tsx?$/, loader: "awesome-typescript-loader" }
  ],

  preLoaders: [
      { test: /\.js$/, loader: "source-map-loader" }
  ]
  externals: {
    "react": "React",
    "react-dom": "ReactDOM"
  },

  devtool: "source-map"
}
